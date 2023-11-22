package com.example.www_java_week04.convert;

import com.example.www_java_week04.enums.SkillType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SkillTypeConvert implements AttributeConverter<SkillType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(SkillType skillType) {
        if(skillType == null) {
            return null;
        }
        return skillType.getValue();
    }

    @Override
    public SkillType convertToEntityAttribute(Integer dbData) {
        if(dbData == 1)
            return SkillType.SOFT_SKILL;
        if(dbData == 0)
            return SkillType.UNSPECIFIC;
        if(dbData == 2)
            return SkillType.TECHNICAL_SKILL;
        return null;
    }
}
