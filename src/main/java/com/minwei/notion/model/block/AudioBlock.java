package com.minwei.notion.model.block;


import com.minwei.notion.model.file.File;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 音频块对象
 *
 * @author lmw 2025/06/16
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class AudioBlock extends Block{

    private File audio;

}
