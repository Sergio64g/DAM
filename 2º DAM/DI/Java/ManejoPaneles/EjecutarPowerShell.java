import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class EjecutarPowerShell
{
	public static void main(String[] args) throws InterruptedException
	{		
		Runtime runtime = Runtime.getRuntime();
		try
		{
			Process process = runtime.exec("powershell.exe  $PSVersionTable.PSVersion");
			
			process.getOutputStream().close();
			String line;
			BufferedReader stdout = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((line = stdout.readLine()) != null){
				System.out.println(line);
			}
		}
		catch(IOException ex){
			System.exit(-1);
		}
	}
}
