package edu.umb.cs680.hw03;

public class Student {
	float tuition;
	String name;
	int i20num;
	int yrsInState;
	String usAddr;
	String foreignAddr;
	String priorStateAddr;
	private StudentStatus status = null;
	

	private Student(String name, int i20num, String usAddr,	int yrsInState, String priorState, 
					String foreignAddr, StudentStatus status)
	{
		this.name=name;
		this.i20num=i20num;
		this.usAddr=usAddr;
		this.yrsInState=yrsInState;
		this.foreignAddr=foreignAddr;
		this.priorStateAddr=priorState;
		this.status=status;
/*		System.out.println("name :"+name+"\n"+"i20num : "+i20num+"\n"+"usAddr : "+usAddr+"\n"+"yrsInState : "+ yrsInState+"\n"+"priorState : "+ priorState+ "\n"+"foreignAddr : "+foreignAddr ); */
	}
	
	public static Student createInStateStudent(String name, String usAddr, int yrsInState)
	{
		return  new Student(name, 0, usAddr, yrsInState, null, null, StudentStatus.INSTATE);
	}

	public static Student createOutStateStudent(String name, String usAddr, String priorState)
	{
		return new Student(name, 0, usAddr, 0, priorState, null, StudentStatus.OUTSTATE);
	}

	public static Student createIntlStudent(String name, String usAddr, int i20num, String foreignAddr)
	{
		return new Student(name, i20num, usAddr, 0, null, foreignAddr, StudentStatus.INTL);
	}
	
	public int geti20num()
	{
		return this.i20num;
	}

	public float getTuition()
	{
		return this.tuition;
	}
	
	public int getyrsInState()
	{
		return this.yrsInState;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String get_us_Addr()
	{
		return this.usAddr;
	}
	
	public String get_prior_Addr()
	{
		return this.priorStateAddr;
	}
	
	public String get_foreign_Addr()
	{
		return this.foreignAddr;
	}
	public StudentStatus getStatus()
	{
		return this.status;
	}
	
	
	/* public static void main(String[] arg) {
		Student S1=Student.createInStateStudent("Mark_InState", "as", 1);
		
	} */
}
