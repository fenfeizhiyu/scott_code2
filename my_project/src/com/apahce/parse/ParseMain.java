package com.apahce.parse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.mylog.FileSource;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import japa.parser.JavaParser;




public class ParseMain {

	public static void main(String[] args) throws JavaModelException, FileNotFoundException {
		try
		{
		FileSource fs=new FileSource("D:\\log\\code");
		String[] fps=fs.getFilesPath();
		Map<String, String> compilerOptions = JavaCore.getOptions();
		 compilerOptions.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_7); //设置Java语言版本
		 compilerOptions.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_7);
		 compilerOptions.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_7);
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		
		parser.setCompilerOptions(compilerOptions);
		//System.out.println(fs.readFileString(fps[0]).toCharArray());
		parser.setSource(fs.readFileString(fps[1]).toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
	
		CompilationUnit result = (CompilationUnit) parser.createAST(null);
		result.accept(new NodeVisitor());
		//System.out.println(result);
	    //result.types();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	   
	
	}

}
