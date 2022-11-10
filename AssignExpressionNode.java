package astCreation;
/**
 * AssignExpressionNode is a specialized binaryExpressionNode
 * This node contains an Identity Node on the left and assignment operator
 * and then an expression on the right.
 * This is useful during the compiling process. Right before Printing, I 
 * transform this node into a more general Binary Node and update the lhs and 
 * any possible references in the rhs to a transNode. 
 * @author Delia -8/16/2022
 *
 */
public class AssignExpressionNode extends BinaryExpressionNode {
	//members
	IdentityNode lhs;
	ExpressionNode rhs;
	int lineNo;
	private int uniqueNo;
	static int count;
	
	public AssignExpressionNode(){
		this.lhs = null;
		this.rhs = null;
		this.uniqueNo = count++;
	}
	
	public AssignExpressionNode(IdentityNode l){
		this.lhs = l;
		this.rhs = null;
		this.uniqueNo = count++;
	}
	
	public AssignExpressionNode(IdentityNode l, ExpressionNode r){
		this.lhs = l;
		this.rhs = r;
		this.uniqueNo = count++;
	}
	
	public void setLhs(IdentityNode l) {
		this.lhs = l;
	}
	
	public IdentityNode getLhs() {
		return this.lhs;
	}
	
	public void setRhs(ExpressionNode r) {
		this.rhs = r;
	}
	
	public ExpressionNode getRhs() {
		return this.rhs;
	}
	
	public void setLineNo(int line) {
		this.lineNo = line;
	}
	
	public int getLineNo() {
		return this.lineNo;
	}
	
	@Override
	public ASTNode[] getChildren() {
		if(this.lhs != null) {
			if(this.rhs !=null) {
				return new ASTNode[] {this.lhs,this.rhs};	
			}else {
				return new ASTNode[] {this.lhs};
			}
		}else if (this.rhs !=null) {
			return new ASTNode[] {this.rhs};
		} else return null;
	}
	
	/*
	 * This is used for precompile treeprinting especially.
	 * I also used it for debugging etc.
	 */
	@Override
	public String getLabel() {
		return ("Assignment_"+Integer.toString(this.uniqueNo));
	}
	
	public void accept(compiler.Visitor visit) {
		visit.visit(this);
		if(this.lhs!=null) {
			this.lhs.accept(visit);
		}
		if(this.rhs!=null) {
			this.rhs.accept(visit);
		}
	}
	
	public void accept(compiler.VisitorPost visit) {
		visit.visit(this);
		if(this.lhs!=null) {
			this.lhs.accept(visit);
		}
		if(this.rhs!=null) {
			this.rhs.accept(visit);
		}
		visit.postVisit(this);
	}
	
	@Override
	public void visit() {
		if(this.lhs!=null) {
			this.lhs.visit();
		}if(this.rhs!=null) {
			this.rhs.visit();
		}
	}
	
}
