package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        Predicate<String> filter_condition = message -> message.contains("simulation");
        FileLogger fileLogger = new FileLogger("log.txt");
        FilteredLogger filteredLogger = new FilteredLogger(fileLogger, filter_condition);
        CompositeLogger compositeLogger = new CompositeLogger(new ConsoleLogger(), filteredLogger);
        return new ContextualLogger(name, compositeLogger);
    }
}
