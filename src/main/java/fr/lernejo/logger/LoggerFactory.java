package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        FileLogger fileLogger = new FileLogger("log.txt");
        CompositeLogger compositeLogger = new CompositeLogger(new ConsoleLogger(), fileLogger);
        return new ContextualLogger(name, compositeLogger);
    }
}
