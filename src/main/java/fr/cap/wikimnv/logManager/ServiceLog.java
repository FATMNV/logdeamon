package fr.cap.wikimnv.logManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceLog implements ILog {
	Logger log = LoggerFactory.getLogger(ServiceLog.class);

	public String logger(LogLevel logLvl, String message) throws Exception {
		String retour = null;
		switch (logLvl) {
		case DEBUG:
			log.debug(message);
			retour = "Retour du logger => le message: ";
			retour +=  message + " a bien été pris en compte";
			retour += " niveau => " + logLvl;			
			break;
		case INFO:
			log.info(message);
			retour = "Retour du logger => le message: ";
			retour +=  message + " a bien été pris en compte";
			retour += " niveau => " + logLvl;
			break;
		case WARN:
			log.warn(message);
			retour = "Retour du logger => le message: ";
			retour +=  message + " a bien été pris en compte";
			retour += " niveau => " + logLvl;		
			break;
		default:
			log.error(message);
			retour = "Retour du logger => le message: ";
			retour +=  message + " a bien été pris en compte";
			retour += " niveau => " + logLvl;		
			break;
		}
		return retour;
	}

}
