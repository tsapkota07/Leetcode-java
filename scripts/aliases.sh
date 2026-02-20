# Scripts/aliases.sh
# Run a leetcode problem by number. 
# Usage: lc 1
# 	 lc 2235
# 	 lc 1 open (cd into the folder)
# 	 lc 1 list (show matches)

lc() {
  if [ -z "$1" ]; then
    echo "Usage: lc <number> [open|list]"
    return 2
  fi

  local n
  n=$(printf "%04d" "$1")

  local runner
  runner=$(find problems -type f -name "Runner.java" -path "*/p${n}_*/*" -print -quit 2>/dev/null)

  if [ -z "$runner" ]; then
    echo "No Runner.java found for problem $1 (expected problems/**/p${n}_*/Runner.java)"
    return 1
  fi

  local dir
  dir=$(dirname "$runner")

  if [ "$2" = "open" ]; then
    cd "$dir" || return 1
    pwd
    return 0
  fi

  if [ "$2" = "list" ]; then
    find problems -type f -name "Runner.java" -path "*/p${n}_*/*" 2>/dev/null | xargs -I{} dirname "{}"
    return 0
  fi

  rm -rf out && mkdir -p out

  local files
  files=($(find "$dir" -maxdepth 1 -name "*.java" -print))
  if [ ${#files[@]} -eq 0 ]; then
    echo "No .java files found in $dir"
    return 1
  fi

  javac -d out "${files[@]}" || return 1

  # Read package from Runner.java (if present)
  local pkg
pkg=$(awk '/^package[[:space:]]+/ { gsub(/package[[:space:]]+/, "", $0); gsub(/;/, "", $0); print; exit }' "$runner")
  if [ -z "$pkg" ]; then
    java -cp out Runner
  else
    java -cp out "${pkg}.Runner"
  fi
}