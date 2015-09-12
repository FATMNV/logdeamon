package fr.cap.wikimnv.logManager;

import java.util.Calendar;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggerMNV {

	ILog sLog;

	public void logEvent(JoinPoint joinPoint) {
		try {
			sLog.logger(LogLevel.INFO, joinPoint.getThis().getClass()
					.getSimpleName()
					+ " : " + joinPoint.getArgs().length);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object logProcess(ProceedingJoinPoint joinPoint) throws Exception {
		Object object = null;
		try {
			sLog.logger(LogLevel.INFO, Calendar.getInstance().getTimeInMillis()
					+ " - Start....." + joinPoint.getSignature().toString());
			object = joinPoint.proceed();
			sLog.logger(LogLevel.INFO, Calendar.getInstance().getTimeInMillis()
					+ " - End....." + joinPoint.getSignature().toString());
		} catch (Throwable e) {
			sLog.logger(
					LogLevel.DEBUG,
					"Erreur non traitée : "
							+ joinPoint.getSignature().toString() + " : "
							+ e.getMessage());
		}
		return object;
	}

	public ILog getsLog() {
		return sLog;
	}

	public void setsLog(ILog sLog) {
		this.sLog = sLog;
	}
}
