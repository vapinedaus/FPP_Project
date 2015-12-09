
public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		this.addWindowStateListener(
			    new WindowAdapter() 
			    {
			        @Overrides
			        public void windowClosing(WindowEvent e) 
			        {
			            ExitAction.getInstance().actionPerformed(null);
			        }

			    });

	}

}
