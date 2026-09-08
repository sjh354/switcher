"""stroke_byte() 인코딩 검증 — 앱 SwitcherBLEService.writeStrokeLevel() 재현.
실행: python test_stroke.py
"""
from switcher_core import stroke_byte

for level in (0, 1, 2):
    for test in (True, False):
        # 앱 원본: Integer.parseInt(str(level) + ("1" if test else "0"), 16)
        expected = int(f"{level}{'1' if test else '0'}", 16)
        assert stroke_byte(level, test) == bytes([expected]), (level, test)

assert stroke_byte(1) == b"\x10"          # 앱이 기기 등록 시 쓰는 값
try:
    stroke_byte(3)
except ValueError:
    pass
else:
    raise AssertionError("level 3은 거부해야 함")

print("OK: 0x00/0x01, 0x10/0x11, 0x20/0x21")
