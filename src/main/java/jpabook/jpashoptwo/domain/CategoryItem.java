package jpabook.jpashoptwo.domain;

import jpabook.jpashoptwo.domain.item.Item;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "category_item")
public class CategoryItem {
    @Id @GeneratedValue
    @Column(name = "category_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
