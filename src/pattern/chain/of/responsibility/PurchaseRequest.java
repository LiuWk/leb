package pattern.chain.of.responsibility;

//采购单：请求类
class PurchaseRequest {
	private double amount; // 采购金额
	private int number; // 采购单编号
	private String purpose; // 采购目的

	public PurchaseRequest(double amount, int number, String purpose) {
		this.amount = amount;
		this.number = number;
		this.purpose = purpose;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return this.amount;
	}

	// 请求的链式处理——职责链模式（三）
	// 253
	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getPurpose() {
		return this.purpose;
	}
}

// 审批者类：抽象处理者
abstract class Approver {
	protected Approver successor; // 定义后继对象
	protected String name; // 审批者姓名

	public Approver(String name) {
		this.name = name;
	}

	// 设置后继者
	public void setSuccessor(Approver successor) {
		this.successor = successor;
	}

	// 抽象请求处理方法
	public abstract void processRequest(PurchaseRequest request);
}

// 主任类：具体处理者
class Director extends Approver {
	public Director(String name) {
		super(name);
	}

	// 具体请求处理方法
	@Override
    public void processRequest(PurchaseRequest request) {
		if (request.getAmount() < 50000) {
			System.out.println("主任" + this.name + "审批采购单：" + request.getNumber());
		} else {
			this.successor.processRequest(request); // 转发请求
		}
	}
}

// 副董事长类：具体处理者
// 请求的链式处理——职责链模式（三）
// 254
class VicePresident extends Approver {
	public VicePresident(String name) {
		super(name);
	}

	// 具体请求处理方法
	@Override
    public void processRequest(PurchaseRequest request) {
		if (request.getAmount() < 100000) {
			System.out.println("副董事长" + this.name + "审批采购单：" + request.getPurpose());
		} else {
			this.successor.processRequest(request); // 转发请求
		}
	}
}

// 董事长类：具体处理者
class President extends Approver {
	public President(String name) {
		super(name);
	}

	// 具体请求处理方法
	@Override
    public void processRequest(PurchaseRequest request) {
		if (request.getAmount() < 500000) {
			System.out.println("董事长" + this.name + "审批采购单：" + request.getNumber());
		} else {
			this.successor.processRequest(request); // 转发请求
		}
	}
}

// 董事会类：具体处理者
class Congress extends Approver {
	public Congress(String name) {
		super(name);
	}

	// 具体请求处理方法
	@Override
    public void processRequest(PurchaseRequest request) {
		System.out.println("召开董事会审批采购单：" + request.getNumber() + "，金额");
	}
}


