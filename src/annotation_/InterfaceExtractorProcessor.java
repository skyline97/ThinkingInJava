package annotation_;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.sun.mirror.apt.*;
import com.sun.mirror.declaration.*;


public class InterfaceExtractorProcessor implements AnnotationProcessor {

	private final AnnotationProcessorEnvironment env;
	
	private ArrayList<MethodDeclaration> interfaceMethods = new ArrayList<MethodDeclaration>();
	
	public InterfaceExtractorProcessor(AnnotationProcessorEnvironment env) {
		this.env = env;
	}
	
	@Override
	public void process() {
		for(TypeDeclaration typeDecl : env.getSpecifiedTypeDeclarations()) {
			ExtractInterface anno = typeDecl.getAnnotation(ExtractInterface.class);
			if(anno == null)
				break;
			for(MethodDeclaration m : typeDecl.getMethods())
				if(m.getModifiers().contains(Modifier.PUBLIC) &&
						!(m.getModifiers().contains(Modifier.STATIC)))
					interfaceMethods.add(m);
			if(interfaceMethods.size() > 0) {
				try {
					PrintWriter writer = env.getFiler().createSourceFile(anno.value());
					writer.println("package " + typeDecl.getPackage().getQualifiedName() + ";");
					writer.println("public interface " + anno.value() + " {");
					for(MethodDeclaration m : interfaceMethods) {
						writer.print("  public");
						writer.print(m.getReturnType() + " ");
						writer.print(m.getSimpleName() + " (");
						int i=0;
						for(ParameterDeclaration p : m.getParameters()) {
							writer.print(p.getType() + " " + p.getSimpleName());
							if(++i < m.getParameters().size())
								writer.print(", ");
						}
						writer.println(");");
					}
					writer.println("}");
					writer.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
