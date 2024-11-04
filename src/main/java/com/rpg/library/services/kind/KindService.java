package com.rpg.library.services.kind;

import com.rpg.library.dto.kind.KindDTO;
import com.rpg.library.dto.kind.KindFormDTO;
import com.rpg.library.entity.kind.Kind;
import com.rpg.library.mappers.kind.KindMapper;
import com.rpg.library.repository.kind.KindRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KindService {
    private final KindRepository kindRepository;
    private final KindMapper kindMapper;

    public List<KindDTO> getAllKinds() {
        return kindRepository.findAll().stream().map(this.kindMapper::toDTO).toList();
    }

    public KindDTO getKindById(Long id) {
        Kind kind = kindRepository.findById(id).orElseThrow();
        return kindMapper.toDTO(kind);
    }

    public KindDTO createKind(KindFormDTO kindFormDTO) {
        Kind kind = kindMapper.toEntity(kindFormDTO);
        return kindMapper.toDTO(kindRepository.save(kind));
    }

    public KindDTO updateKind(Long id, KindFormDTO kindFormDTO) {
        Kind kind = kindRepository.findById(id).orElseThrow();
        kindMapper.updateFromKindFormDTO(kindFormDTO, kind);
        return kindMapper.toDTO(kindRepository.save(kind));
    }

    public void deleteById(Long id) {
        kindRepository.deleteById(id);
    }
}
