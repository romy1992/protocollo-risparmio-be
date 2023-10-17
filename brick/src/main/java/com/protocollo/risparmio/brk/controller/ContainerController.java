package com.protocollo.risparmio.brk.controller;

import com.protocollo.risparmio.brk.model.ContainerModel;
import com.protocollo.risparmio.brk.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/container")
public class ContainerController {
  @Autowired ContainerService containerService;

  @PostMapping("insert/user")
  public ContainerModel insert(@RequestBody ContainerModel model) {
    return containerService.insert(model);
  }

  @GetMapping("search/{codUser}")
  public List<ContainerModel> search(@PathVariable(name = "codUser") String codUser) {
    return containerService.search(codUser);
  }

  @PutMapping("update")
  public ContainerModel update(@RequestBody ContainerModel model) {
    return containerService.update(model);
  }

  @DeleteMapping("delete/{idContainer}")
  public Boolean delete(@PathVariable(name = "idContainer") UUID idContainer) {
    return containerService.delete(idContainer);
  }

  @DeleteMapping("delete/all/{codUser}")
  public Boolean deleteAll(@PathVariable(name = "codUser") String codUser) {
    return containerService.deleteAllContainers(codUser);
  }
}
