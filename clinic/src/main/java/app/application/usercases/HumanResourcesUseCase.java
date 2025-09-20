package app.application.usercases;

import app.domain.model.User;
import app.domain.model.emuns.Role;
import app.domain.services.CreateUser;
import app.domain.services.CreateUser.UpdateUser;

public class HumanResourcesUseCase {
	
	private CreateUser createUser;
	private UpdateUser updateUser;

	public void createDoctors(User user) throws Exception {
		user.setRole(Role.DOCTORS);
		createUser.createUser(user);
	}
	
	public void createNurse(User user) throws Exception {
		user.setRole(Role.NURSE);
		createUser.createUser(user);
	}
	
	public void createHumanResources(User user) throws Exception {
		user.setRole(Role.HUMANRESOURCES);
		createUser.createUser(user);
	}
	
	public void createSupport(User user) throws Exception {
		user.setRole(Role.SUPPORT);
		createUser.createUser(user);
	}
	
	
	public void updateRrHh(User user) throws Exception {
        user.setRole(Role.HUMANRESOURCES);
        updateUser.update(user);
    }

   
    public void updateInformationSupport(User user) throws Exception {
        user.setRole(Role.SUPPORT);
        updateUser.update(user);
    }

    public void updateNurse(User user) throws Exception {
        user.setRole(Role.NURSE);
        updateUser.update(user);
    }

    public void updateDoctor(User user) throws Exception {
        user.setRole(Role.DOCTORS);
        updateUser.update(user);
    }

}
