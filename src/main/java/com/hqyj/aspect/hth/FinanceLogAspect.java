package com.hqyj.aspect.hth;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hqyj.mapper.hth.ErpsysFinanceLogMapper;
import com.hqyj.model.hth.ErpsysAccountsPayable;
import com.hqyj.model.hth.ErpsysAccountsReceivable;
import com.hqyj.model.hth.ErpsysExpenditure;
import com.hqyj.model.hth.ErpsysFinanceLog;
import com.hqyj.model.hth.ErpsysRecord;
import com.hqyj.service.hth.FinancialManagementExpenditureBillService;
import com.hqyj.service.hth.FinancialManagementRecordBillService;

@Component("financeLogAspect")
@Aspect
public class FinanceLogAspect {
	
	@Autowired
	private HttpServletRequest request;//获得本次请求的request
	
	@Autowired
	private ErpsysFinanceLogMapper erpsysFinanceLogMapper;//日志表mapper
	
	@Autowired
	private FinancialManagementRecordBillService fmrbs;//入账表mapper
	
	@Autowired
	private FinancialManagementExpenditureBillService fmebs;//出账表mapper
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	
	@After("execution(* com.hqyj.service.im.hth.*.insertRecordBill(..))")
	public void recordBillInsertAspect(JoinPoint point){
		try {
			ErpsysRecord record = (ErpsysRecord)point.getArgs()[0];//取得插入的账单record
			HttpSession session = request.getSession();//通过request得到session
			ErpsysFinanceLog erpsysFinanceLog = new ErpsysFinanceLog();//new一个log对象
			erpsysFinanceLog.setOperation("新增入账账单 id=" + record.getRecordId());//操作行为
			erpsysFinanceLog.setAccountId((String)session.getAttribute("username"));//得到操作人员名字
			Date date = new Date();//得到当前时间
			erpsysFinanceLog.setOperationTime(date);//将时间注入对象
			erpsysFinanceLogMapper.insert(erpsysFinanceLog);//插入日志到数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After("execution(* com.hqyj.service.im.hth.*.updateRecordBill(..))")
	public void recordBillUpdateAspect(JoinPoint point){
		try {
			ErpsysRecord record = (ErpsysRecord)point.getArgs()[0];//取得修改好的账单record
			HttpSession session = request.getSession();//通过request得到session
			ErpsysFinanceLog erpsysFinanceLog = new ErpsysFinanceLog();//new一个log对象
			erpsysFinanceLog.setOperation("修改入账账单 id=" + record.getRecordId());//操作行为
			erpsysFinanceLog.setAccountId((String)session.getAttribute("username"));//得到操作人员名字
			Date date = new Date();//得到当前时间
			erpsysFinanceLog.setOperationTime(date);//将时间注入对象
			erpsysFinanceLogMapper.insert(erpsysFinanceLog);//插入日志到数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@After("execution(* com.hqyj.service.im.hth.*.deleteRecordBill(..))")
	public void recordBillDeleteAspect(JoinPoint point){
		try {
			int recordId = (int)point.getArgs()[0];//取得删除的账单recordId
			HttpSession session = request.getSession();//通过request得到session
			ErpsysFinanceLog erpsysFinanceLog = new ErpsysFinanceLog();//new一个log对象
			erpsysFinanceLog.setOperation("删除入账账单 id=" + recordId);//操作行为
			erpsysFinanceLog.setAccountId((String)session.getAttribute("username"));//得到操作人员名字
			Date date = new Date();//得到当前时间
			erpsysFinanceLog.setOperationTime(date);//将时间注入对象
			erpsysFinanceLogMapper.insert(erpsysFinanceLog);//插入日志到数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After("execution(* com.hqyj.service.im.hth.*.insertExpenditureBill(..))")
	public void expenditureBillInsertAspect(JoinPoint point){
		try {
			ErpsysExpenditure expenditure = (ErpsysExpenditure)point.getArgs()[0];//取得插入的账单expenditure
			HttpSession session = request.getSession();//通过request得到session
			ErpsysFinanceLog erpsysFinanceLog = new ErpsysFinanceLog();//new一个log对象
			erpsysFinanceLog.setOperation("新增出账账单 id=" + expenditure.getExpenditureId());//操作行为
			erpsysFinanceLog.setAccountId((String)session.getAttribute("username"));//得到操作人员名字
			Date date = new Date();//得到当前时间
			erpsysFinanceLog.setOperationTime(date);//将时间注入对象
			erpsysFinanceLogMapper.insert(erpsysFinanceLog);//插入日志到数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After("execution(* com.hqyj.service.im.hth.*.updateExpenditureBill(..))")
	public void expenditureBillUpdateAspect(JoinPoint point){
		try {
			ErpsysExpenditure expenditure = (ErpsysExpenditure)point.getArgs()[0];//取得修改好的账单expenditure
			HttpSession session = request.getSession();//通过request得到session
			ErpsysFinanceLog erpsysFinanceLog = new ErpsysFinanceLog();//new一个log对象
			erpsysFinanceLog.setOperation("修改出账账单 id=" + expenditure.getExpenditureId());//操作行为
			erpsysFinanceLog.setAccountId((String)session.getAttribute("username"));//得到操作人员名字
			Date date = new Date();//得到当前时间
			erpsysFinanceLog.setOperationTime(date);//将时间注入对象
			erpsysFinanceLogMapper.insert(erpsysFinanceLog);//插入日志到数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@After("execution(* com.hqyj.service.im.hth.*.deleteExpenditureBill(..))")
	public void expenditureBillDeleteAspect(JoinPoint point){
		try {
			int expenditureId = (int)point.getArgs()[0];//取得删除的账单expenditureId
			HttpSession session = request.getSession();//通过request得到session
			ErpsysFinanceLog erpsysFinanceLog = new ErpsysFinanceLog();//new一个log对象
			erpsysFinanceLog.setOperation("删除出账账单 id=" + expenditureId);//操作行为
			erpsysFinanceLog.setAccountId((String)session.getAttribute("username"));//得到操作人员名字
			Date date = new Date();//得到当前时间
			erpsysFinanceLog.setOperationTime(date);//将时间注入对象
			erpsysFinanceLogMapper.insert(erpsysFinanceLog);//插入日志到数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After("execution(* com.hqyj.service.im.hth.*.insertAccountsPayable(..))")
	public void accountsPayableInsertAspect(JoinPoint point){
		try {
			ErpsysAccountsPayable accountsPayable = (ErpsysAccountsPayable)point.getArgs()[0];//取得插入的账单expenditure
			HttpSession session = request.getSession();//通过request得到session
			ErpsysFinanceLog erpsysFinanceLog = new ErpsysFinanceLog();//new一个log对象
			erpsysFinanceLog.setOperation("新增应出账务 id=" + accountsPayable.getAccountsPayableId());//操作行为
			erpsysFinanceLog.setAccountId((String)session.getAttribute("username"));//得到操作人员名字
			Date date = new Date();//得到当前时间
			erpsysFinanceLog.setOperationTime(date);//将时间注入对象
			erpsysFinanceLogMapper.insert(erpsysFinanceLog);//插入日志到数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After("execution(* com.hqyj.service.im.hth.*.updateAccountsPayable(..))")
	public void accountsPayableUpdateAspect(JoinPoint point){
		try {
			ErpsysAccountsPayable accountsPayable = (ErpsysAccountsPayable)point.getArgs()[0];//取得插入的账单expenditure
			HttpSession session = request.getSession();//通过request得到session
			ErpsysFinanceLog erpsysFinanceLog = new ErpsysFinanceLog();//new一个log对象
			erpsysFinanceLog.setOperation("修改应出账务 id=" + accountsPayable.getAccountsPayableId());//操作行为
			erpsysFinanceLog.setAccountId((String)session.getAttribute("username"));//得到操作人员名字
			Date date = new Date();//得到当前时间
			erpsysFinanceLog.setOperationTime(date);//将时间注入对象
			erpsysFinanceLogMapper.insert(erpsysFinanceLog);//插入日志到数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@After("execution(* com.hqyj.service.im.hth.*.deleteAccountsPayable(..))")
	public void accountsPayableDeleteAspect(JoinPoint point){
		try {
			int accountsPayableId = (int)point.getArgs()[0];//取得删除的账单expenditureId
			HttpSession session = request.getSession();//通过request得到session
			ErpsysFinanceLog erpsysFinanceLog = new ErpsysFinanceLog();//new一个log对象
			erpsysFinanceLog.setOperation("删除应出账务 id=" + accountsPayableId);//操作行为
			erpsysFinanceLog.setAccountId((String)session.getAttribute("username"));//得到操作人员名字
			Date date = new Date();//得到当前时间
			erpsysFinanceLog.setOperationTime(date);//将时间注入对象
			erpsysFinanceLogMapper.insert(erpsysFinanceLog);//插入日志到数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After("execution(* com.hqyj.service.im.hth.*.insertAccountsReceivable(..))")
	public void accountsReceivableInsertAspect(JoinPoint point){
		try {
			ErpsysAccountsReceivable accountsReceivable = (ErpsysAccountsReceivable)point.getArgs()[0];//取得插入的账单expenditure
			HttpSession session = request.getSession();//通过request得到session
			ErpsysFinanceLog erpsysFinanceLog = new ErpsysFinanceLog();//new一个log对象
			erpsysFinanceLog.setOperation("新增应收账务 id=" + accountsReceivable.getAccountsReceivableId());//操作行为
			erpsysFinanceLog.setAccountId((String)session.getAttribute("username"));//得到操作人员名字
			Date date = new Date();//得到当前时间
			erpsysFinanceLog.setOperationTime(date);//将时间注入对象
			erpsysFinanceLogMapper.insert(erpsysFinanceLog);//插入日志到数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After("execution(* com.hqyj.service.im.hth.*.updateAccountsReceivable(..))")
	public void accountsReceivableUpdateAspect(JoinPoint point){
		try {
			ErpsysAccountsReceivable accountsReceivable = (ErpsysAccountsReceivable)point.getArgs()[0];//取得插入的账单expenditure
			HttpSession session = request.getSession();//通过request得到session
			ErpsysFinanceLog erpsysFinanceLog = new ErpsysFinanceLog();//new一个log对象
			erpsysFinanceLog.setOperation("修改应收账务 id=" + accountsReceivable.getAccountsReceivableId());//操作行为
			erpsysFinanceLog.setAccountId((String)session.getAttribute("username"));//得到操作人员名字
			Date date = new Date();//得到当前时间
			erpsysFinanceLog.setOperationTime(date);//将时间注入对象
			erpsysFinanceLogMapper.insert(erpsysFinanceLog);//插入日志到数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@After("execution(* com.hqyj.service.im.hth.*.deleteAccountsReceivable(..))")
	public void accountsReceivableDeleteAspect(JoinPoint point){
		try {
			int accountsReceivableId = (int)point.getArgs()[0];//取得删除的账单expenditureId
			HttpSession session = request.getSession();//通过request得到session
			ErpsysFinanceLog erpsysFinanceLog = new ErpsysFinanceLog();//new一个log对象
			erpsysFinanceLog.setOperation("删除应收账务 id=" + accountsReceivableId);//操作行为
			erpsysFinanceLog.setAccountId((String)session.getAttribute("username"));//得到操作人员名字
			Date date = new Date();//得到当前时间
			erpsysFinanceLog.setOperationTime(date);//将时间注入对象
			erpsysFinanceLogMapper.insert(erpsysFinanceLog);//插入日志到数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After("execution(* com.hqyj.service.im.xsh.OrderMannagementServiceIm.addOrder(..))")
	public void orderInsertAspect(JoinPoint point){
		HttpServletRequest request = (HttpServletRequest)point.getArgs()[0];
		//0销售，1采购
		try {
			double productionTotalPrice = Double.parseDouble(request.getParameter("productionTotalPrice"));
			int orderType = Integer.parseInt(request.getParameter("orderType"));
			Date date = new Date();
			String timeString = sdf.format(date);
			if(orderType==0){//销售订单
				ErpsysRecord record = new ErpsysRecord();
				record.setRecordMoney(productionTotalPrice);
				record.setRecordTimeString(timeString);
				record.setRecordReason("销售订单");
				fmrbs.insertRecordBill(record);//插入入账账单
			}else{//采购订单
				ErpsysExpenditure erpsysExpenditure = new ErpsysExpenditure();
				erpsysExpenditure.setExpenditureMoney(productionTotalPrice);
				erpsysExpenditure.setExpenditureTimeString(timeString);
				erpsysExpenditure.setExpenditureReason("采购订单");
				fmebs.insertExpenditureBill(erpsysExpenditure);//插入出账账单
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
