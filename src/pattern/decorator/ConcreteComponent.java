package pattern.decorator;

/**
 * @author lwk
 * 扩展功能
 */
public class ConcreteComponent extends Decorator {

	public ConcreteComponent(Component component) {
		super(component);
		// TODO Auto-generated constructor stub
	}
	@Override
    public void operation()
	{
		super.operation(); //调用原有业务方法
		addedBehavior(); //调用新增业务方法
	}
	//新增业务方法
	public void addedBehavior()	{

	}
}
