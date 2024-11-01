package com.rpg.library.controllers.kind;

import com.rpg.library.services.kind.KindService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/kinds")
public class KindController {
    private final KindService kindService;
}
