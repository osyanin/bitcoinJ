package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class TestBase {

    protected static Logger logger = LogManager.getLogger(TestBase.class);

    protected Map<String, Object> jsonBody = new HashMap<>();

}
