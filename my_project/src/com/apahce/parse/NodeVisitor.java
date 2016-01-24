package com.apahce.parse;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MemberRef;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;

public class NodeVisitor extends ASTVisitor{

	@Override
	public boolean visit(MethodDeclaration node) {
		// TODO Auto-generated method stub
		System.out.println(node.getName());
		return super.visit(node);
	}

	

	

	

	
}
