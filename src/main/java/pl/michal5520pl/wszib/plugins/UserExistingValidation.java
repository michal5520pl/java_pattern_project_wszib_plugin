package pl.michal5520pl.wszib.plugins;

import java.util.List;

import pl.michal5520pl.wszib.GenericHandler;
import pl.michal5520pl.wszib.DatabaseProxy;
import pl.michal5520pl.wszib.User;

public class UserExistingValidation extends GenericHandler {
    UserExistingValidation(final DatabaseProxy dbProxy, final User user, final List<String> handlers){
        super(dbProxy, user, handlers);
    }

    public Boolean checkUserExistance(final User user){
        if(getDbProxy().containsUser(user)){
            logger.error("Database contains the user!");
            return false;
        }

        logger.info("User %s is not in the database, continuing...".formatted(user.getUsername()));
        return true;
    }
}
