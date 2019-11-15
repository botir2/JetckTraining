package com.example.jetcktraining.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Note {
    private String leftTopText;
    private String leftBottomText;
    private String rightTopText;
    private String rightBottomText;
    private int CeterImage;
    private int ImageDowm;
    private int backGroudColor;
}
