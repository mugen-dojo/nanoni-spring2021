{ pkgs ? import (fetchTarball "https://github.com/NixOS/nixpkgs/archive/00f9323c2717e4b2ed0b3c38c107a75de4198562.tar.gz") {} }:

pkgs.mkShell {
    name = "Les Nanoni Bots";
    buildInputs = with pkgs; [
        git
        boot
        nodejs
    ];
}
