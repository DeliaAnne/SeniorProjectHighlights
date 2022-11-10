package astCreation;

import compiler.Visitor;
import compiler.VisitorPost;
import drive.Types;
/**
 * This is the basic node patern
 * It was not abstract initially, it became abstract.
 * @author Delia
 *
 */
public abstract class ASTNode{
	String label="ASTNODE";
	int lineNo;
	String mangled;
	
	public void visit() {}

	public void setLineNo(int line) {
		this.lineNo = line;
	}
	
	public int getLineNo() {
		return this.lineNo;
	}
	
	public ASTNode[] getChildren() {
		return null;
	}
	
	public Types litToType(ASTNode a) {
		if(a.getClass() == NumberNode.class) {
			return Types.INT;
		}else if(a.getClass() == CharNode.class) {
			return Types.CHAR;
		}else if(a.getClass() == BoolNode.class) {
			return Types.BOOL;
		}else return Types.VOID;
	}
	
	public void setMangled(String st) {
		this.mangled = st;
	}
	
	public String getMangled() {
		return this.mangled;
	}
	
	public String dotVisit() {
		return this.label;
	}
	
	public String getLabel(){
		return this.label;
	}

	public abstract void accept(Visitor visit);

	public abstract void accept(VisitorPost visit);
}