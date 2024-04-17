import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarRestauranteComponent } from './listar-restaurante.component';

describe('ListarRestauranteComponent', () => {
  let component: ListarRestauranteComponent;
  let fixture: ComponentFixture<ListarRestauranteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListarRestauranteComponent]
    });
    fixture = TestBed.createComponent(ListarRestauranteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
