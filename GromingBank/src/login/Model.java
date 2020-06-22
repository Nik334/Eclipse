package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import tranaction.Transaction;

public class Model 
{
	private String name;
	private String custId;
	private String accNo;
	private String pws;
	private String balance;
	private String email;
	private Connection conn;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getPws() {
		return pws;
	}
	public void setPws(String pws) {
		this.pws = pws;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Model() 
	{
		try 
		{
			//DriverManager.registerDriver(new OracleDriver());
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded...");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Driver loding failed");
		}
			
		try
		{
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String usrName = "SYSTEM";
			String pws = "root";
			conn = DriverManager.getConnection(url, usrName, pws);
			System.out.println("Connection successfully...");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Connection failed...");
		}
	}
	public boolean login()
	{
		try {
			String qry = "select * from BANKAPP where custid = ? and pws = ?";
			PreparedStatement pstm = conn.prepareStatement(qry);
			pstm.setString(1, custId);
			pstm.setString(2, pws);
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
			{
				accNo = rs.getString("accountno");
				name = rs.getString("name");
				email = rs.getString("email");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean accBalance()
	{
		try {
			String qry = "select * from BANKAPP where accountno=?";
			PreparedStatement pstm = conn.prepareStatement(qry);
			pstm.setString(1, accNo);
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
			{
				balance = rs.getString("balance");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkOldPws()
	{
		try {
			String qry = "select * from bankapp where accountNo = ?";
			PreparedStatement pstm = conn.prepareStatement(qry);
			pstm.setString(1, accNo);
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
			{
				pws = rs.getString("pws");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean changePws(String newPws)
	{
		try {
			String qry = "update bankapp set pws = ? where accountNo = ? ";
			PreparedStatement pstm = conn.prepareStatement(qry);
			pstm.setString(1, newPws);
			pstm.setString(2, accNo);
			int check = pstm.executeUpdate();
			if(check == 1){
				return true;
			}
			else{
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean isAccountValid(String accountValidate,String nameValidate)
	{
		try {
			String qry = "select * from bankapp where accountNo = ? and name = ?";
			PreparedStatement pstm = conn.prepareStatement(qry);
			pstm.setString(1, accountValidate);
			pstm.setString(2, nameValidate);
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
			{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean isAccountValid(String custIdValidate)
	{
		try {
			String qry = "select * from bankapp where CUSTID = ?";
			PreparedStatement pstm = conn.prepareStatement(qry);
			pstm.setString(1, custIdValidate);
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
			{
				email = rs.getString("EMAIL");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean isTranferAmount(int amt)
	{
		try {
			String qry="select * from bankapp where accountNo = ?";
			PreparedStatement pstm = conn.prepareStatement(qry);
			pstm.setString(1, accNo);
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
			{
				balance = rs.getString("BALANCE");
			}
			if(Integer.parseInt(balance)>=amt)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean tranferAmount(Transaction t)
	{
		try {
			String qry1 = "update bankapp set balance = balance - ? where accountNo = ?";
			String qry2 = "update bankapp set balance = balance + ? where accountNo = ?";
			PreparedStatement pstm1 = conn.prepareStatement(qry1);
			PreparedStatement pstm2 = conn.prepareStatement(qry2);
			pstm1.setString(1, t.getTranactionAmount());
			pstm1.setString(2, accNo);
			pstm2.setString(1, t.getTranactionAmount());
			pstm2.setString(2, t.getTranactionAccountNo());
			int rows1 = pstm1.executeUpdate();
			int rows2 = pstm2.executeUpdate();
			
			if(rows1 > 0 && rows2 > 0)
			{
				System.out.println("rows1 => " + rows1 + " rows2 => " + rows2);
				String qry3 = "insert into TRANSATIONS values (?, ?, ?, ?)";
				PreparedStatement pstm3 = conn.prepareStatement(qry3);
				pstm3.setString(1, accNo);
				pstm3.setString(2, t.getTranactionAmount());
				pstm3.setString(3, t.getTranactionAccountNo());
				pstm3.setString(4, t.getTranactionAccountHolderName());
				int rows3 = pstm3.executeUpdate();
				if(rows3 > 0)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Transaction> getStatement()
	{
		ArrayList<Transaction> ar = new ArrayList<Transaction>();
		try {
			String qry = "select * from TRANSATIONS where ACCOUNTNO = ?";
			PreparedStatement pstm = conn.prepareStatement(qry);
			pstm.setString(1, accNo);
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
			{
				Transaction t = new Transaction();
				t.setTranactionAccountHolderName(rs.getString("TRANFERACCOUNTHOLDERNAME"));
				t.setTranactionAccountNo(rs.getString("TRANFERACOUNTNO"));
				t.setTranactionAmount(rs.getString("TRANFERAMOUNT"));
				ar.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	public boolean setRandomPwd(String password)
	{
		try {
			String qry = "update bankapp set pws = ? where custId = ?";
			PreparedStatement pstm = conn.prepareStatement(qry);
			pstm.setString(1, password);
			pstm.setString(2, custId);
			int rows = pstm.executeUpdate();
			if(rows > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
