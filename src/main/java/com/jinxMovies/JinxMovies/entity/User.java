package com.jinxMovies.JinxMovies.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String hashPassword;
    private String email;
    private String phoneNumber;
    private String profilePictureUrl;
    private LocalDate dateOfBirth;
    private String gender;
    private boolean emailVerified;
    private String verificationToken;
    private String resetPasswordToken;
    private boolean isActive;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BookMark> bookMarks = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<WatchList> watchLists = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<WatchHistory> watchHistories = new ArrayList<>();


    public User(String userName, String hashPassword, String email, String phoneNumber, String profilePictureUrl, LocalDate dateOfBirth, String gender, boolean emailVerified, String verificationToken, String resetPasswordToken, boolean isActive, List<BookMark> bookMarks, List<WatchList> watchLists, List<WatchHistory>watchHistories) {
        this.userName = userName;
        this.hashPassword = hashPassword;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.profilePictureUrl = profilePictureUrl;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.emailVerified = emailVerified;
        this.verificationToken = verificationToken;
        this.resetPasswordToken = resetPasswordToken;
        this.isActive = isActive;
        this.bookMarks = bookMarks;
        this.watchLists = watchLists;
        this.watchHistories = watchHistories;
    }
    public void addBookmark(BookMark bookmark) {
        bookMarks.add(bookmark);
        bookmark.setUser(this);
    }

}
