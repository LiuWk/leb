package pattern.state;

public class OverdraftState extends AccountState {

	public OverdraftState(AccountState state) {
		super();
		this.acc = state.acc;
	}
	
	public OverdraftState(Account acc) {
		this.acc = acc;
	}

	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void computeInterest() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stateCheck() {
		// TODO Auto-generated method stub

	}

}
