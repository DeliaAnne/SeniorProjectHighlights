
package astCreation;

/**
 * Extends ExpressionNode Holds an ExpressionNode for the literalValue
 * Holds an ASTNode for the statement following
 * @author Delia
 *
 */
public class CaseStatementNode extends ExpressionNode {
	ExpressionNode lit;
	ASTNode stmt;
	String label = "caseStatement";
	int lineNo;
	int uniqueNo;
	static int count = 0;
	
	public CaseStatementNode(){
		this.lit = null;
		this.stmt = null;
		this.uniqueNo = count++;
	}
	
	public CaseStatementNode(ExpressionNode l, ASTNode s){
		this.lit = l;
		this.stmt = s;
		this.uniqueNo = count++;
	}
	
	public ExpressionNode getLiteral() {
		return this.lit;
	}
	
	public ASTNode getStatementBlock() {
		return this.stmt;
	}
	
	public void setLineNo(int line) {
		this.lineNo = line;
	}
	
	public int getLineNo() {
		return this.lineNo;
	}
	
	public void accept(compiler.Visitor visit) {
		visit.visit(this);
		if(this.lit!=null) {
			this.lit.accept(visit);
		}else if(this.stmt!=null) {
			this.stmt.accept(visit);
		}
	}
	
	public void accept(compiler.VisitorPost visit) {
		visit.visit(this);
		if(this.lit!=null) {
			this.lit.accept(visit);
		}else if(this.stmt!=null) {
			this.stmt.accept(visit);
		}
		visit.postVisit(this);
	}
	
	@Override
	public ASTNode[] getChildren() {
		if (this.lit!= null && this.stmt !=null) {
			return new ASTNode[] {lit,stmt};
		}else if(this.lit!=null) {
			return new ASTNode[] {lit};
		}else if(this.stmt!=null) {
			return new ASTNode[] {stmt};
		} else return null;
	}
	
	@Override
	public String getLabel() {
		return this.label+"_"+Integer.toString(uniqueNo);
	}
	
	@Override
	public void visit() {
		if(this.lit!=null) {
			this.lit.visit();
		}else if(this.stmt!=null) {
			this.stmt.visit();
		}
	}
}
