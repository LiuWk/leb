package pattern.compent;

import java.util.ArrayList;
import java.util.List;

//文件夹类：容器构件
public class Folder extends AbstractFile {
	private List<AbstractFile> files = new ArrayList<>();
	private String name;

	@Override
	public void add(AbstractFile file) {
		files.add(file);
	}

	@Override
	public void remove(AbstractFile file) {
		files.remove(file);
	}

	@Override
	public AbstractFile getChild(int i) {
		return files.get(i);
	}

	@Override
	public void killVirus() {
		System.out.println("****对文件夹'" + name + "'进行杀毒"); // 模拟杀毒
		// 递归调用成员构件的killVirus()方法
		for (Object obj : files) {
			((AbstractFile) obj).killVirus();
		}
	}

	/**
	 * @param name
	 */
	public Folder(String name) {
		super();
		this.name = name;
	}

}
