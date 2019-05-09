package java_server;

import java.util.Properties;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class BotHandler {

	private String threadId;
	private Map<String, HashMap<String, String>> outerMap = new HashMap<String, HashMap<String, String>>();
	private HashMap<String, String> innerMap = new HashMap<String, String>();

	public BotHandler() {
	}

	/**
	 * Creates a new Bot with the Given Configuration and starts it in its own
	 * Thread. Configuration and associated threadId are saved to Hashmap via
	 * Function addThreadToMap
	 * 
	 * @param botConfig  Bot Configuration consisting of 'link', 'name', 'botId',
	 *                   'interval'
	 * @param mailConfig --- NOT IMPLEMENTED ---
	 */
	public void createBot(Properties botConfig, Properties mailConfig) {
		Thread newBotThread = new Thread(new WillhabenBot(botConfig, mailConfig));
		this.threadId = String.valueOf(newBotThread.getId());
		this.addThreadToMap(botConfig, mailConfig, this.threadId);
		newBotThread.start();
		System.out.println("BotHanlder Created Bot with ThreadId " + this.threadId);
	}

	/**
	 * Stops a running Bot by matching the BotId to the corresponding threadId and
	 * Interrupting the Thread via interruptThread() Function
	 * 
	 * @param botId generated by the GUI Client
	 */
	public void stopBot(String botId) {
		this.innerMap = this.outerMap.get(botId);
		interruptThread(this.innerMap.get("threadId"));
	}

	/**
	 * Start an existing Bot by referencing its id and loading the configurations
	 * from the HashMap
	 * 
	 * @param botId generated by the GUI Client
	 */
	public void startBot(String botId) {
		this.innerMap = this.outerMap.get(botId);
		Properties botConfig = convertToBotConfig(this.innerMap);
		Properties mailConfig = convertToMailConfig(this.innerMap);
		System.out.println("Starting Existing Bot with ID " + botId);
		this.createBot(botConfig, mailConfig);

	}

	/**
	 * Creates a set of all running Threads, iterates through the set until the
	 * threadId matches the passed argument threadId and then sends interrupt to the
	 * Thread
	 * 
	 * @param threadId ThreadId of Thread to kill
	 */
	private void interruptThread(String threadId) {
		Set<Thread> setOfThread = Thread.getAllStackTraces().keySet();
		for (Thread thread : setOfThread) {
			if (thread.getId() == Long.parseLong(threadId)) {
				thread.interrupt();
				System.out.println("Interrupted Thread " + threadId + " via BotHandler");
			}
		}

	}
	
	/**
	 * Converts a given Property to HashMap
	 * @param props
	 * @return Converted HashMap
	 */
	private Map<String, String> convertToMap(Properties props) {
		Map<String, String> propMap = new HashMap(props);
		return propMap;
	}

	/**
	 * Converts a map in the correct Format to the botConfig Property for use with WillhabenBot Class
	 * @param map
	 * @return Converted botConfig Property
	 */
	private Properties convertToBotConfig(Map<?, ?> map) {
		String[] botConfigItems = { "link", "name", "botId", "interval" };
		Properties botConfig = new Properties();
		for (int i = 0; i < botConfigItems.length; i++) {
			botConfig.put(botConfigItems[i], map.get(botConfigItems[i]));
		}
		return botConfig;
	}
	
	/**
	 * Converts a map in the correct Format to the mailConfig Property for use with WillhabenBot Class
	 * @param map
	 * @return Converted mailConfig Property --- NOT IMPLEMENTED ---
	 */
	private Properties convertToMailConfig(Map<?, ?> map) {
		Properties mailConfig = new Properties();
		return mailConfig;
	}

	/**
	 * Adds the Bot Configurations and threadId to map, then adds this generated map to outerMap which is access by the key *botId*
	 * @param botConfig botConfig Property
	 * @param mailConfig botConfig Property
	 * @param threadId ID of Thread this Bot is running in
	 */
	private void addThreadToMap(Properties botConfig, Properties mailConfig, String threadId) {
		this.innerMap = new HashMap<String, String>();
		innerMap.putAll(convertToMap(botConfig));
		innerMap.putAll(convertToMap(mailConfig));
		innerMap.put("threadId", threadId);
		outerMap.put(botConfig.getProperty("botId"), innerMap);
	}

}
