package com.example.doctorkom.Services.UserProfileService;

public interface UserProfileService<T> {
    T getUserProfile(String username);

    void updateUserProfile(T userProfile);
}
