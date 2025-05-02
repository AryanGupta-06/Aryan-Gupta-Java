package Java_collections_worksheet_1;

import java.util.*;

class Asset {
    private String id;
    private String name;

    public Asset(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Asset{id='" + id + "', name='" + name + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asset asset = (Asset) o;
        return Objects.equals(id, asset.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class Q11_Company_Asset_Tracker {
    private Map<String, Set<Asset>> departmentAssets = new HashMap<>();

    public void addAsset(String department, Asset asset) {
        departmentAssets.computeIfAbsent(department, k -> new HashSet<>()).add(asset);
    }

    public void detectDuplicateAssets() {
        Map<String, List<Asset>> assetIdMap = new HashMap<>();

        for (Set<Asset> assets : departmentAssets.values()) {
            for (Asset asset : assets) {
                assetIdMap.computeIfAbsent(asset.getId(), k -> new ArrayList<>()).add(asset);
            }
        }

        boolean duplicatesFound = false;
        for (Map.Entry<String, List<Asset>> entry : assetIdMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                duplicatesFound = true;
                System.out.println("Duplicate Asset ID: " + entry.getKey());
                for (Asset asset : entry.getValue()) {
                    System.out.println(asset);
                }
            }
        }

        if (!duplicatesFound) {
            System.out.println("No duplicate asset IDs found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q11_Company_Asset_Tracker tracker = new Q11_Company_Asset_Tracker();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Asset");
            System.out.println("2. Detect Duplicate Assets");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter asset ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter asset name: ");
                    String name = scanner.nextLine();
                    tracker.addAsset(department, new Asset(id, name));
                    break;
                case 2:
                    tracker.detectDuplicateAssets();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
