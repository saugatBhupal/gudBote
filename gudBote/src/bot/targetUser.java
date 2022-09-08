package bot;

public class targetUser {
    private String[] userList = {"nirakar", "kripesh82","anakin5kywalker"};

    public boolean isTargetUser(String user){
        boolean isTarget = false;
        for(int i = 0; i<userList.length;i ++){
            if(user.equals(userList[i])){
                isTarget = true;
            }
            else{
                isTarget = false;
            }
        }
        return isTarget;
    }
}
