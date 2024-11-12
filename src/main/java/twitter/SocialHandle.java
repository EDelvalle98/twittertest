package twitter;

import java.util.HashSet;

public class SocialHandle {
    HashSet<String> listOfHandles = new HashSet<>();


    public String createHandle(String yourSocialHandle) {
        if (yourSocialHandle == null || yourSocialHandle.trim().isEmpty()) {
            return "Handle cannot be empty or blank.";
        }
        yourSocialHandle = yourSocialHandle.toLowerCase();

        if (yourSocialHandle.length() > 9) {
            yourSocialHandle = yourSocialHandle.substring(0, 9);
        }

        // Always add the '@' symbol at the start of the handle
        yourSocialHandle = "@" + yourSocialHandle;

        return yourSocialHandle;
    }


    public void addHandle(String yourSocialHandle){
        String formattedHandle = createHandle(yourSocialHandle);

        if (formattedHandle.equals("Handle cannot be empty or blank.")) {
            System.out.println("Handle cannot be empty or blank.");
            return;
        }

        if (listOfHandles.contains(formattedHandle)) {
            System.out.println("Handle already exists!");
        } else {
            listOfHandles.add(formattedHandle);
            System.out.println("Handle added successfully: " + formattedHandle);
        }
    }

    public void removeHandle(String yourSocialHandle){
        if (listOfHandles.contains(yourSocialHandle)) {
            listOfHandles.remove(yourSocialHandle);
        } else {
            System.out.println("Handle does not exist.");
        }
    }

    public HashSet<String> getHandles() {
        return listOfHandles;
    }
}

