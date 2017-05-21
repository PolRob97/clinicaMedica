import java.time.LocalDateTime;

public class Util {
	
	public static boolean checkifOccupied(LocalDateTime dataInizioAppuntamento, 
			LocalDateTime dataFineAppuntamento, LocalDateTime dataInizioPaziente, LocalDateTime dataFinePaziente){
		if(dataInizioAppuntamento.getYear() != dataInizioPaziente.getYear())
			return false;
		else{
			
			if(dataInizioAppuntamento.getMonth().getValue() != dataInizioPaziente.getMonth().getValue())
				return false;
			else{
				if(dataInizioAppuntamento.getDayOfMonth() != dataInizioPaziente.getDayOfMonth())
					return false;
				else{
					if(dataInizioAppuntamento.getHour() == dataInizioPaziente.getHour()
							&& dataFineAppuntamento.getHour() == dataFinePaziente.getHour()){
						if(dataInizioAppuntamento.getMinute() == dataInizioPaziente.getMinute()
								&& dataFineAppuntamento.getMinute() == dataFinePaziente.getMinute())
							return true;
					}
					
					if(dataInizioAppuntamento.getHour() == dataInizioPaziente.getHour()){
						if(dataInizioAppuntamento.getMinute() < dataInizioPaziente.getMinute()){
							if(dataFineAppuntamento.getMinute() < dataInizioPaziente.getMinute())
								return false;
						}
					}
					
					if(dataInizioAppuntamento.getHour() < dataInizioPaziente.getHour() && 
						dataFineAppuntamento.getHour() < dataInizioPaziente.getHour())
						return false;
					if(dataInizioAppuntamento.getHour() > dataInizioPaziente.getHour() 
						&& dataInizioAppuntamento.getHour() > dataFinePaziente.getHour())
					return false;
				
					if(dataInizioAppuntamento.getHour() < dataInizioPaziente.getHour() 
						&& dataFineAppuntamento.getHour() == dataInizioPaziente.getHour()){
					if(dataFineAppuntamento.getMinute() < dataInizioPaziente.getMinute())
						return false;
				}
			}
		}
		
		
		}
		return true;
	}
}
