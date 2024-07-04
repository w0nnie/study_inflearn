package hello.itemservice.item;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import hello.itemservice.domain.item.UpdateItem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void tearDown() {
        itemRepository.clearStore();
    }

    @Test
    void save() {

        //given
        Item item = new Item("itemA", 20000, 10);

        //when
        itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(item).isEqualTo(findItem);
    }

    @Test
    void findAll() {
        //given
        Item itemA = new Item("itemA", 10000, 10);
        Item itemB = new Item("itemB", 20000, 20);
        itemRepository.save(itemA);
        itemRepository.save(itemB);
        //when
        List<Item> result = itemRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(itemA, itemB);
    }

    @Test
    void update() {
        //given
        Item itemA = new Item("itemA", 10000, 10);
        itemRepository.save(itemA);
        UpdateItem updateItem = new UpdateItem("itemB", 20000, 20);

        //when
        itemRepository.update(itemA.getId(), updateItem);

        //then
        assertThat(itemA.getItemName()).isEqualTo(updateItem.getItemName());
        assertThat(itemA.getPrice()).isEqualTo(updateItem.getPrice());
        assertThat(itemA.getQuantity()).isEqualTo(updateItem.getQuantity());
    }

    @Test
    void remove() {
        //given
        Item itemA = new Item("itemA", 10000, 10);
        itemRepository.save(itemA);
        Long itemAId = itemA.getId();

        //when
        itemRepository.remove(itemAId);
        List<Item> result = itemRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(0);
    }
}