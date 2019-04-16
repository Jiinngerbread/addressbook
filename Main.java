import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import swing2swt.layout.BoxLayout;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Main {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private AddressBook ab;
	private 

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Main window = new Main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setTouchEnabled(true);
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		CLabel lblNewLabel_1 = new CLabel(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblNewLabel_1.setBounds(145, 10, 139, 21);
		lblNewLabel_1.setText("Address Book");
		
		CLabel lblUsername = new CLabel(shell, SWT.NONE);
		lblUsername.setBounds(55, 46, 67, 21);
		lblUsername.setText("Username:");
		
		CLabel lblPassword = new CLabel(shell, SWT.NONE);
		lblPassword.setBounds(61, 92, 61, 21);
		lblPassword.setText("Password:");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(123, 46, 185, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(123, 92, 185, 21);
		
		Button btnLogin = new Button(shell, SWT.NONE);
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnLogin.setBounds(116, 147, 75, 25);
		btnLogin.setText("LogIn");
		
		Button btnExit = new Button(shell, SWT.NONE);
		btnExit.setBounds(233, 147, 75, 25);
		btnExit.setText("Exit");

	btnLogin.addListener(SWT.Selection,new Listener()){
		public void handleEvent(Event event) {
			userName = userNameTxt.getText();
			password = passwordTxt.getText();
			
			if (event.getSource()== LogIn) {
				ab.statusToLaunch();
				
				
            }
			
		}
			
			
		}
	}
	
	
	}
}
