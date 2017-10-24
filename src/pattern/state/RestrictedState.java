package pattern.state;

public class RestrictedState extends AccountState {

	public RestrictedState(Account acc) {
		super();
		this.acc = acc;
	}
	
	public RestrictedState(AccountState state) {
		this.acc = state.acc;
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
