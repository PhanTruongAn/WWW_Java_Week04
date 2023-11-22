package com.example.www_java_week04.convert;

import com.example.www_java_week04.enums.SkillLevel;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SkillLevelConvert implements AttributeConverter<SkillLevel, Integer> {
    @Override
    public Integer convertToDatabaseColumn(SkillLevel skillLevel) {
        if(skillLevel == null) {
            return null;
        }
        return skillLevel.getValue();
    }

    @Override
    public SkillLevel convertToEntityAttribute(Integer dbData) {
        if(dbData == 0)
            return SkillLevel.BEGINNER;
        if(dbData == 1)
            return SkillLevel.INTERMEDIATE;
        if(dbData == 2)
            return SkillLevel.ADVANCE;
        if(dbData == 3)
            return SkillLevel.MASTER;
        if(dbData == 4)
            return SkillLevel.PROFESSIONAL;
        return null;
    }
}
