package org.jahia.modules.healthcheck.probes;

import org.jahia.modules.healthcheck.Probe;
import org.jahia.utils.DatabaseUtils;
import org.json.JSONObject;

import java.sql.SQLException;

public class DBConnectivityProbe implements Probe {


    @Override
    public String getStatus()  {
        try {
            // The timeout value is defined in seconds.
            if (DatabaseUtils.getDatasource().getConnection().isValid(20)) {
                return "GREEN";
            } else {
                return "RED";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "RED";
        }

    }

    @Override
    public JSONObject getData() {
        return null;
    }

    @Override
    public String getName() {
        return "DBConnectivity";
    }
}
