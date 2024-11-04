package com.rpg.library.controllers.kind;

import com.rpg.library.dto.kind.KindDTO;
import com.rpg.library.dto.kind.KindFormDTO;
import com.rpg.library.services.kind.KindService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/kinds")
public class KindController {
    private final KindService kindService;

    @GetMapping
    public List<KindDTO> getAllKinds() {
        return kindService.getAllKinds();
    }

    @GetMapping("/{id}")
    public KindDTO getKindById(@PathVariable Long id) {
        return kindService.getKindById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public KindDTO createKind(@RequestBody KindFormDTO kindFormDTO) {
        return kindService.createKind(kindFormDTO);
    }

    @PutMapping("/{id}")
    public KindDTO updateKind(@PathVariable Long id, @RequestBody KindFormDTO kindFormDTO) {
        return kindService.updateKind(id, kindFormDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteKind(@PathVariable Long id) {
        kindService.deleteById(id);
    }
}
