package ro.unibuc.pao.utils;

import ro.unibuc.pao.logging.Logger;
import ro.unibuc.pao.logging.LoggerFactory;
import ro.unibuc.pao.logging.LoggerType;

public final class AppUtils {

    private AppUtils() {
    }

    public static void showMenu()
    {
        Logger logger = LoggerFactory.getLogger(LoggerType.CONSOLE);

        logger.logInfo("Please select and option");
        logger.logInfo("show -> show characters list");
        logger.logInfo("details -> show character details");
        logger.logInfo("add items -> Add items to your character");
        logger.logInfo("exit -> Exit");
    }
}