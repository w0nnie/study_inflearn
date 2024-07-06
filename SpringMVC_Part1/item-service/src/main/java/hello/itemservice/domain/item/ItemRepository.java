package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 상품 목록
 * 상품 상세
 * 상품 등록
 * 상품 수정
 * 상품 삭제
 */
@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;



    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        Item item = store.get(id);
        return item;
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, UpdateItem updateItem) {
        Item item = findById(itemId);
        item.setItemName(updateItem.getItemName());
        item.setPrice(updateItem.getPrice());
        item.setQuantity(updateItem.getQuantity());
    }

    public void remove(Long itemId) {
        store.remove(itemId);
    }

    public void clearStore() {
        store.clear();
    }

}
