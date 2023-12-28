package category;

import java.util.List;

import rewards.Rewards;

public class Category {

    private String nameCategory;
    private List<Rewards> rewards;

    public Category(String nameCategory, List<Rewards> rewards) {
        this.nameCategory = nameCategory;
        this.rewards = rewards;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Rewards> getRewards() {
        return rewards;
    }

    public void setRewards(List<Rewards> rewards) {
        this.rewards = rewards;
    }
}
