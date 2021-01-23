
import org.apache.logging.log4j.LogManager;

class TestingLogger

fun main() {

    val logger = LogManager.getLogger(TestingLogger::class.java)

    //These logs will be sent to socket server as configured in log4j.xml
    logger.error("Log4j socket appender test run successfully!!");

    logger.info("Log4j socket appender test run successfully!!");

}