package com.protocollo.risparmio.brk.controller;

import com.protocollo.risparmio.brk.model.ContainerModel;
import com.protocollo.risparmio.brk.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/container")
@CrossOrigin(origins = {"http://localhost:3000","https://protocollo-risparmio.netlify.app/"})
public class ContainerController {
  @Autowired ContainerService containerService;

  @PostMapping("insert/user")
  public ContainerModel insert(@RequestBody ContainerModel model) {
    return containerService.insert(model);
  }

  @GetMapping("search/{codUser}")
  public ContainerModel search(@PathVariable(name = "codUser") String codUser) {
    return containerService.search(codUser);
  }

  /**
   * Cerca i mesi IN LIKE
   *
   * @param codUser
   * @param value
   * @return
   */
  @GetMapping("searchInLike")
  public ContainerModel searchInLike(
      @RequestParam(name = "codUser") String codUser, @RequestParam(name = "value") String value) {
    return containerService.searchMouthInLike(codUser, value);
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
