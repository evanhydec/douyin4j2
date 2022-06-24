package com.example.POJO;

import com.example.DTO.userDto;

public class video {
    private Integer id;
    private userDto user;
    private String play_url;
    private String cover_url;
    private Integer favorite_count;
    private Integer comment_count;
    private boolean is_favorite;
    private String title;
    private Integer createdAt;

    @Override
    public String toString() {
        return "video{" +
                "id=" + id +
                ", user=" + user +
                ", play_url='" + play_url + '\'' +
                ", cover_url='" + cover_url + '\'' +
                ", favorite_count=" + favorite_count +
                ", comment_count=" + comment_count +
                ", is_favorite=" + is_favorite +
                ", title='" + title + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public userDto getUser() {
        return user;
    }

    public void setUser(userDto user) {
        this.user = user;
    }

    public String getPlay_url() {
        return play_url;
    }

    public void setPlay_url(String play_url) {
        this.play_url = play_url;
    }

    public String getCover_url() {
        return cover_url;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }

    public Integer getFavorite_count() {
        return favorite_count;
    }

    public void setFavorite_count(Integer favorite_count) {
        this.favorite_count = favorite_count;
    }

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public boolean isIs_favorite() {
        return is_favorite;
    }

    public void setIs_favorite(boolean is_favorite) {
        this.is_favorite = is_favorite;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public video() {
    }

    public video(Integer id, userDto user, String play_url, String cover_url, Integer favorite_count, Integer comment_count, boolean is_favorite, String title, Integer createdAt) {
        this.id = id;
        this.user = user;
        this.play_url = play_url;
        this.cover_url = cover_url;
        this.favorite_count = favorite_count;
        this.comment_count = comment_count;
        this.is_favorite = is_favorite;
        this.title = title;
        this.createdAt = createdAt;
    }
}
