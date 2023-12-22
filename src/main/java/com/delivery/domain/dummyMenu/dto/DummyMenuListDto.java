package com.delivery.domain.dummyMenu.dto;


import com.delivery.domain.dummyMenu.entity.DummyMenu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DummyMenuListDto {
    private List<DummyMenu> dummyMenus;
}
